
# latex-templates

for when you're writing research papers

## Code snippets regarding the typesetting language

### Code for inserting graphics

```latex
\usepackage{graphicx}
```

### Code for APA-style citations

```latex
\usepackage{natbib}

[... snip ...]

\citep{name} % cites like: (Name, year)
\citet{name} % cites like: Name (year)
\citet[p. 42]{name} % cites like: Name (year, p. 42)

%put this at the end of the document:
\begin{thebibliography}{9}
% Example citation:
% \bibitem[\protect\citename{Doe et al., }2000]{name}
% Doe, J. M., Smith, A., \& Dore, J. D. (2000). Example title \textit{Some Journal, Vol(No),} page-page.

\end{thebibliography}

```

### Code for adding a watermark and setting its text & size

```latex
\usepackage{draftwatermark}
\SetWatermarkText{Confidential}
\SetWatermarkScale{5}
```

### Code for strikethroughs on a piece of text

```latex
\usepackage{cancel} %preamble

[... snip ...]

\cancel{text to cancel} % draws a diagonal line (slash) through its argument
\bcancel{text to cancel} % uses the negative slope (a backslash)
\xcancel{text to cancel} % draws an X (actually \cancel plus \bcancel)
\cancelto{<value>}{<expression>} % draws a diagonal arrow through the <expression> pointing to the <value> (math-mode only)
```

## References
* https://tex.stackexchange.com/questions/186981/is-there-a-subsubsubsection-command
* https://texblog.org/2012/02/17/watermarks-draft-review-approved-confidential/
* https://www.techwalla.com/articles/how-to-make-a-dashed-line-in-microsoft-word
* https://www.overleaf.com/learn/latex/Line_breaks_and_blank_spaces
* https://tex.stackexchange.com/questions/9363/how-does-one-insert-a-backslash-or-a-tilde-into-latex
* https://jansoehlke.com/2010/06/strikethrough-in-latex/
* https://latex.org/forum/viewtopic.php?t=5852
