all: j9.pdf
	
j9.pdf:
	latexmk -xelatex j9 

clean:
	git clean -fx

open: j9.pdf
	pdfpc --disable-compression --last-minutes=5 --duration=20 j9.pdf

.PHONY: all clean open
