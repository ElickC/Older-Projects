name    hello
        .model small
        .stack  100
        .data
		
prompt db ' seconds have elapsed since midnight.$',13,10
input db ?

output db 13,10, 'The character you entered was: $'
   


 .code 
		start:     
                _Begin
				
				
				call TimeInSeconds

				mov input, eax
				call GetDec
				_PutStr prompt

TimeInSeconds	PROC
				_GetDate
				mov eax, ch
				imul 60 
				imul 60
				mov hours, eax
				mov eax, cl
				imul 60
				add eax, hours
				add eax, dh
				ret
TimeInSeconds	ENDP


ch contains the hour (0-23)

cl contains the minute (0-59)

dh contains the second (0-59)

and returns in eax the total number of seconds that have elapsed since midnight.
				


				
        end start
