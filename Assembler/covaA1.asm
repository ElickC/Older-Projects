; File Name:  covaA1.asm
; Written by: Elick Coval
; Challenges:  Getting "certificate" to display correctly, some syntax issues, had to include both pcmac and util
; Time Spent:  About 8 hours
; Given Input: 			         Expected Output: 
; --------------------          -------------------------
; This program will take a single character input from the user (letter grade) and display it in the certificate with the system date
;
; 1)  A							Grade:A
; 2)  B							Grade:B
; 3)  C							Grade:C
; Revision History
; Date:         Revised By:      Action:
; ------------------------------------------------------------------
; 10/9/16    	EC  			Started working on certificate framework.	
; 10/9/16		EC				Moved date code from previous project and worked on ordering of macros.
; 10/11/16		EC				Aligned the certificate and got the input and date displaying correctly.
 
name    Certificate   

INCLUDELIB UTIL.LIB
INCLUDE PCMAC.INC
       .model small
	   .586
       .stack  100
       .data
	   
Prompt DB 'Enter a letter grade:$',13,10   ; Declare user input prompt
	   
First DB 13,10, 6 DUP('* * * * * '),13,10, '$'											; Beginning of Certificate 
Second DB  '* * * * *            This Certifies that          * * * * *',13,10,'$'
Third DB '* * * * *               Elick M. Coval            * * * * *',13,10,'$'
Fourth DB '* * * * *         has mastered Input/Output       * * * * *',13,10,'$'
Fifth DB '* * * * *           in Assembly Language          * * * * *',13,10,'$'
Sixth DB '* * * * *                  Grade:$'
TailofSix DB '                * * * * *', '$'
Seventh DB 13,10,"* * * * *          Today's date: $"
TailofSeven DB '       * * * * *','$'													; End of Certificate

Input DB ?			; Declare variables needed to hold values
Month DB ?			
Day	DB ?			
Year DW ?			


		.code 
EXTRN PutDec:NEAR
		
Certificate 	PROC		    

		_Begin				; Start program and prompt for grade
		_PutStr Prompt
		
		mov ah, 08h			; Accept user input
		int 21h
		mov Input, al
		
		_PutStr First		; Display certificate up to the date
		_PutStr Second
        _PutStr Third
		_PutStr Fourth
		_PutStr Fifth
		_PutStr Sixth
		_PutCh Input		; Display user inputted grade
		_PutStr TailofSix
		_PutStr Seventh
		
		_GetDate			; Get system date
		
		mov Month,dh
		mov Day,dl
		mov Year,cx
		
		mov al,Month		; Display system date
		mov ah,0
		call PutDec
		
		_PutCh '/'
		
		mov al,Day
		mov ah, 0
		call PutDec	
		
		_PutCh '/'
		
		mov ax,Year
		call PutDec
		
		_PutStr TailofSeven		; Display rest of the certificate
		_PutStr First

		_Exit 0					; Exit without errors
		
Certificate ENDP
        end Certificate
