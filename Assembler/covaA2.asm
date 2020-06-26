; File Name: Calculator
; Written by: Elick Coval
; Challenges: Correctly displaying inputs.
; Time Spent: 5hrs 
; Given Input: (3 sets)         Expected Output: (3 corresponding sets)
; --------------------          -------------------------
;  5 / 7						The result of 5 / 7 is 0 and the remainder is 5
;  8 / 0 						Cannot divide by zero.
;  2 * 10						The result of 2 * 10 is 20
;  15 + 20						The result of 15 + 20 is 35
;  -5 - 9						The result of -5 - 9 is -14
;
; Revision History
; Date:         Revised By:      Action:
; ------------------------------------------------------------------
; 11/12/2016	EC				Set up decision logic and jumps for sign choice and worked
;								on getting everything displaying correctly.
;
; 11/13/2016    EC				Finalized the math logic and only display remainder
;								for division.
; 
INCLUDE PCMAC.INC

       .model small
	   .586
       .stack  100
       .data
	   
intPromptA DB 'Enter first integer:$',13,10		; Prompt messages
opPrompt DB 'Enter operator:$',13,10
intPromptB DB 'Enter second integer:$',13,10
resultMsgA DB 'The result of $'	   				; Result messages
resultMsgB DB ' is $'
resultMsgC DB ' and the remainder is $',13,10
errorMsg DB 'Cannot divide by zero.$',13,10		; Error message
									 
op DB ' $'										; Variables
remain DW ?
result DW ?

		.code 
		
EXTRN PutDec:NEAR, GetDec:NEAR
		
Calculator 	PROC		    

			_Begin
			
MyLoop:		_PutStr intPromptA		; Get first integer and put it into bx
			call GetDec
			mov bx, ax
			
			_PutStr opPrompt		; Get the operator and put it into op
			_GetCh
			mov op, al
			_PutCh 13,10

			_PutStr intPromptB		; Get second integer and put it into cx
			call GetDec
			mov cx, ax
			
			cmp op, '+'				
			je Addition				; Jump to addition if the inputted operator was +
			cmp op, '-'
			je Subtract				; Jump to subtraction if the inputted operator was -
			cmp op, '*'
			je Multiply				; Jump to multiplication if the inputted operator was *
			cmp op, '/'
			je Divide				; Jump to division if the inputted operator was /
			jmp MyLoop				; Loop if none of those were entered
		
Addition:	mov ax, bx				; Perform addition and put the result into variable to be printed later
			add ax, cx
			mov result, ax
			jmp Print				; Jump to print
		
Subtract:	mov ax, bx				; Perform subtraction and put the result into variable to be printed later
			sub ax, cx
			mov result, ax
			jmp Print				; Jump to print
		
Multiply:	mov ax, bx				; Perform multiplication and put the result into variable to be printed later
			imul cx
			mov result, ax
			jmp Print				; Jump to print
		
Divide: 	cmp cx, 0				; Perform division and put the result into variable to be printed later
			je Zero					; Do not perform calculation if the user tries to divide by 0
			mov ax, bx
			cwd						; Sign extend
			idiv cx
			mov result, ax			; Store dividend
			mov remain, dx			; Store remainder
			jmp Print				; Jump to print

Print:		_PutCh 13,10			; Print result of calculation
			_PutStr resultMsgA
			mov ax,bx
			call PutDec
			_PutCh ' '
			_PutStr op
			_PutCh ' '
			mov ax,cx
			call PutDec
			_PutStr resultMsgB
			mov ax, result
			call PutDec
			cmp op, '/'				
			je Remainder			; Jump to remainder print block if operation was division
			jmp Exit
			
Remainder:  _PutStr resultMsgC		; Print remainder
			mov ax, remain
			call PutDec
			jmp Exit
		
Zero:		_PutStr errorMsg		; Divide by zero error message and quit
Exit:		_Exit 0
		
Calculator ENDP
        end Calculator
