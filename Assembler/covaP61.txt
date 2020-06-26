name    hello
        .model small
        .stack  100
        .data
		
prompt db 'Enter a character:$',13,10
input db ?

output db 13,10, 'The character you entered was: $'
   


 .code 
		start:     
                mov ax, @data
                mov ds, ax
      
				lea dx, prompt
                mov ah, 09h  
				int 21h
     
				;mov ah, 01h
				;int 21h
				;mov input, al
				
				mov ah, 08h
				int 21h
				mov input, al
				
				lea dx, output
				mov ah, 09h
				int 21h
		
				mov ah, 02h
				mov dl, input
				int 21h
				
				mov ax, 4c00h      
                int 21h
				
        end start
