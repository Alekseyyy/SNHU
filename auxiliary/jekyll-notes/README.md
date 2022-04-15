# Jekyll Notes

[Jekyll (n.d.)](https://jekyllrb.com/) is a static website generator that renders Markdown, Kramdown and (presumably) other formats. These are just my notes for customising and extending it --- as I simply cannot be bothered to go through the pain of looking these things up in a search engine anymore (lol). I did my best to give credit where it's due with regards to the person (or organisation) that published a solution to my problem.

## "Esoteric" uses of Markdown

[Buscay (2015)](http://www.seanbuscay.com/blog/jekyll-toc-markdown/) describes markup that they used to generate a __table of contents:__

```markdown
* TOC
{:toc}
```

They note that the markdown should be set to kramdown in the ```_config.yml```.

<hr/>

["JuanPablo" (2011)](https://stackoverflow.com/questions/4629675/jekyll-markdown-internal-links) asked a question regarding internal links that led to some interesting facts regarding internal links:

Links to blog posts can be made like this:
```markdown
[Some Link]({% post_url 2010-07-21-name-of-post %})
```

Links to documents can be made like this:
```markdown
{{ site.baseurl }}{% link _collection/name-of-document.md %}
{{ site.baseurl }}{% link _posts/2016-07-26-name-of-post.md %}
{{ site.baseurl }}{% link news/index.html %}
{{ site.baseurl }}{% link /assets/files/doc.pdf %}
```

## Troubleshooting

## References

Buscay, S. (2015). _How I Add a Table of Contents to my Jekyll Blog Written in Markdown._ SeanBuscay.com. Retrieved on Apr. 15, 2022 from: http://www.seanbuscay.com/blog/jekyll-toc-markdown/

"JuanPablo" (2011). _jekyll markdown internal links._ Stack Overflow. Retrieved on Apr. 15, 2022 from: https://stackoverflow.com/questions/4629675/jekyll-markdown-internal-links

