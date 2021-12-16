## A solution to Easiest Crackme

By A. S. "Aleksey" Ahmann \<hackermaneia@riseup.net\>

Problem link: https://crackmes.one/crackme/6115567333c5d45db85dc17a

This one was pretty easy (it took me about two minutes to crack lol). I extracted the ``CRACKME.EXE`` file from its archive, launched it and found two textboxes, one that takes a "\[n\]ame" and another that takes a "\[s\]erial." I typed in "Test" to both the ``name`` and ``serial`` textboxes, and SenTDI called me a luser :-(

I then decompiled the .NET executable with [dnSpy](https://github.com/dnSpy/dnSpy) and inspected the crackme's programme logic. It organises a namespace called `Xz` and the main form is ``Form1`` (typical). Reading ``Form1``'s source code, I came across this snippet in the ``InitializeComponent`` method:

``` c#
	[ ... snip ... ]

	this.button1.Click += delegate(object a, EventArgs e){
	if (this.textBox2.Text == Convert.ToBase64String(Encoding.UTF8.GetBytes(this.textBox1.Text))){
		MessageBox.Show("Good job", "OK");
		return;
	}
	MessageBox.Show("Looser", "ERROR");
};
```

With a CS freshman-level coding background and a bit of guesswork, I concluded that the solution was a random string ``k`` for the ``name`` textbox, and its base64 representation for the ``serial`` textbox. So, I picked the string "dna deniers" for the ``name`` textbox, and used [CyberChef](https://gchq.github.io/CyberChef)'s base64 encoder to "whip up" a base64 encoding of my string, which is: ``ZG5hIGRlbmllcnM=``

By typing in the "name" ``dna deniers`` and "serial" ``ZG5hIGRlbmllcnM=``, it told me that I did a good job :D
