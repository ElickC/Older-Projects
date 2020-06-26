
name    P51   

INCLUDELIB UTIL.LIB
INCLUDE PCMAC.INC
       .model small
	   .586
       .stack  100
       .data
	   
Prompt DB ' if ((X>5) and (Y<0)) or (Z<=13) then A = 10 else A = 2$',13,10   ;  prompt
PromptX ' Enter X$'13,10
PromptY ' Enter Y$'13,10
PromptZ ' Enter Z$' 13,10


X DB ?			
Y DB ?			
Z DB ?			
First DB 'A = 2$',13,10
Second DB 'A = 10$',13,10			


		.code 
EXTRN GetDec:NEAR,PutDec:NEAR
		
P51 	PROC		    

				_Begin				
				_PutStr Prompt
				_PutStr PromptX
				call GetDec
				mov X,ax
				_PutStr PromptY
				mov Y,ax
				_PutStr PromptZ
				mov Z,ax

				cmp ax, 14
				jle Condition
				
				mov ax,5
				cmp X,ax
				jg One
				
				_PutStr Second
				
One:			mov ax,0
				cmp Y,ax
				jl Condition

Condition:		_PutStr First
		
				
		
				_Exit 0					; Exit without errors
		
P51 ENDP
        end P51
