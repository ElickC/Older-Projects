INCLUDE PCMAC.INC

name    stack
        .model small
        .stack  100
        .data
		
prompt db 'Enter a number: $',13,10
displayAnother db 'Another number is: $',13,10
display db 'You original number was: ',13,10


output db 13,10, 'The character you entered was: $'
   
EXTRN PutDec:NEAR, GetDec:NEAR


 .code 
		start:     
                _Begin
				
				_PutStr prompt
				call GetDec
				push ax
				
				call another
				_PutStr display
				pop ax
				call PutDec

another	PROC
				_PutStr prompt
				call GetDec
				push ax
				_PutStr displayAnother
				pop ax
				call PutDec
				ret
another	ENDP


        end start
