
INCLUDE PCMAC.INC

       .model small
	   .586
       .stack  100
       .data
	   
intPromptA DB 'Enter first integer:$',13,10
opPrompt DB 'Enter operator:$',13,10
intPromptB DB 'Enter second integer:$',13,10
resultMsgA DB 'The result of $'	   
resultMsgB DB ' is $'
resultMsgC DB ' and the remainder is $',13,10
errorMsg DB 'Cannot divide by zero.$',13,10

intA DB ?
intB DB ?
op DB ?
remain DB ?
result DW ?

		.code 
		
EXTRN PutDec:NEAR, GetDec:NEAR
		
Today 	PROC		    

		_Begin
		
		_PutStr intPromptA
		GetDec
		mov intA, ax

		_PutStr intPromptB
		GetDec
		mov intB, ax
		
		_PutStr opPrompt
		GetDec
		mov op, ax
		
		cmp intB, 0
		je Zero
		
		cmp op, '+'
		je Plus
		cmp op, '-'
		je Minus
		cmp op, '*'
		je Mult
		cmp op, '/'
		je Divide

		
Plus:	mov ax, intA
		add ax, intB
		mov result, ax
		jmp Print
		
Minus:	mov ax, intA
		sub ax, intB
		mov result, ax
		jmp Print
		
Mult:	mov ax, intA
		imul intB
		mov result,ax
		jmp Print
		
Divide: mov ax, intA
		imul intB
		mov result,ax
		jmp Print

Print:	_PutStr resultMsgA
		mov ax,intA
		PutDec
		_PutCh op
		mov ax,intB
		PutDec
		_PutStr resultMsgB
		mov ax, result
		PutDec
		_PutStr resultMsgC
		mov ax, remain
		PutDec
		jmp Exit
		
Zero:	_PutStr errorMsg
Exit:	_Exit 0
		
Today ENDP
        end Today
