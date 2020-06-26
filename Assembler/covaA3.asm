; File Name:  covaA3.asm
; Written by: Elick Coval
; Challenges: Getting the order of values on the stack, being able to access those values later, nested looping
; Time Spent:  About 7 hours
; Given Input: 			         Expected Output: 
; --------------------          -------------------------
; This program will accept a character and 2 int values(width and height) and draw a box of that character with those dimensions
;
; 1)  @ , 4, 3					@@@@
;								@@@@
;								@@@@
; 
; Revision History
; Date:         Revised By:      Action:
; ------------------------------------------------------------------
; 11/27/16    	EC  			Started working on initial prompts and getting values on to the stack.	
; 12/1/16		EC				Used print statements to verify that the correct values are getting passed but loop isn't working.
; 12/2/16		EC				Figured out how to get the nested loop working correctly and clean up before and after return.
 

INCLUDE PCMAC.INC
		
        .model small
		.586
        .stack  100
        .data
		
askChar db 'Enter a character: $',13,10									; Prompt variables
askWidth db 'Enter the width: $',13,10
askHeight db 'Enter the height: $',13,10
another db 'Would you like to draw another box? (Y/N)$',13,10


 .code 
   
EXTRN PutDec:NEAR, GetDec:NEAR


	main	PROC   
            _Begin
theLoop:	
			_PutCh 13,10			; Collect char to duplicate convert it to a word and push it on the stack
			_PutStr askChar
			_GetCh
			cbw
			push ax
			
			_PutCh 13,10			; Collect width and push it on the stack
			_PutStr askWidth
			call GetDec
			push ax
			
			_PutStr askHeight		; Collect height and push it on the stack
			call GetDec
			push ax
				
			call drawbox			; Call subprocedure
			
			add esp, 6				; Perform clean up, move stack pointer back
			
			_PutStr another			; Ask if user wants to draw another box
			_GetCh
			cmp al,'N'
			jne theLoop
				
			_Exit 0
    main	ENDP
		
drawbox		PROC

			push ebp				; Push location of base pointer onto the stack
			mov ebp, esp			; Set the new base pointer value
			push bx					; Push registers to save them
			push cx
			push dx
					

			mov bx, [ebp+6]			; Move the number of rows (height) into bx
						
outerLoop:							; Outerloop exit when bx is 0
			cmp bx, 0
			je done
			mov cx, [ebp+8]			; Move the number of times the char will be displayed (width) to cx
			
innerLoop:
			mov dx, [ebp+10]		; Move the char into dx, later PutCh will get used again
			_PutCh 		
			loop innerLoop
			_PutCh 13,10			; Carraige return when row is done
			dec bx		
			jmp outerLoop
done:		
			
			pop dx					; Clean up before return
			pop cx
			pop bx
			mov esp, ebp
			pop ebp

			ret
drawbox		ENDP		
		
		end main