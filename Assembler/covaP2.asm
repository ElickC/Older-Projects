name    hello
       .model small
       .stack  100
       .data
msgA  	  db 'All '
	  db 'on one '
	  db 'line',13,10,'$'

msgB 	  db  13,10,'One if by land,',13,10
		  db 'Two if by sea.',13,10,'$'

msgC 	  db  13,10,'One, ',13,10,'Two, ',13,10,'Three',13,10,'$'

msgD 	  db  13,10,'One $',13,10,'Two, ',13,10,'Three',13,10,'$'

msgE 	  db  13,10,'S',10 DUP('h'),'!',13,10,'$'	  

msgF	  db  13,10, 4 DUP(5 DUP('*'),13,10),'$'

msgG 	  db  13,10, 10 DUP('*'),13,10
		  db  3 DUP('*',8 DUP(' '),'*',13,10)
		  db  10 DUP('*'),13,10,'$'

       .code 
start:     
                mov       ax, @data
                mov       ds, ax
		mov       ah, 9   
    		lea dx, msgA
                int       21h
		lea dx, msgB
		int	  21h
		lea dx, msgC
		int	  21h
		lea dx, msgD
		int	  21h
		lea dx, msgE
		int	  21h
		lea dx, msgF
		int	  21h
		lea dx, msgG
		int	  21h

                mov       ax, 4c00h      
                int       21h
                end       start

 
