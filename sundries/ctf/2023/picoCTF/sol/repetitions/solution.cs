// This is a "work in progress."
// By A. S. "Aleksey" Ahmann

using System;
using System.Text;

class solution {

    public static void main(string[] args) {
        string enc_file = File.ReadAllText("enc_file")
        enc_file = enc_file.Replace("\n", "")
        int i = 1;
        bool done = false;
        while (!done) {
            string enc_input = Encoding.UTF8.GetString(Convert.FromBase64String(encodedStr));
            Console.WriteLine("Iterations: " + Convert.ToString(i));
            if (enc_input.Contains("picoCTF")) {
                Console.WriteLine("Flag:" + enc_input);
            }
            i++;
        }
    }
}
