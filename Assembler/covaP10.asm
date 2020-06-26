INCLUDE PCMAC.INC


N		EQU 80



.MODEL SMALL
.586
.STACK 100h
.DATA


prompt	DB 'Enter the password: $', 13,10

buffer	DB N+1,0					; _GetStr adds CR at end, needs one more byte
pword 	DB N+1 'JackCakes $'

.CODE
		EXTRN  GetDec :NEAR, PutDec : NEAR
Main:   _Begin  	
	
ask:	_PutStr prompt
		_GetStr buffer
		
		sub bx,bx
		mov bx, [buffer+1]	
		sub di,di
		sub cx,cx
		
firstLoop:
		cmp [pword + di], bx
		inc bx
		inc cx
		je firstLoop
		cmp cx, 5
		je exit
		jmp ask
exit:		
		
		_PutStr greet		; greeting	
		_PutStr uname		; print out user name, plus exclamantion point

        _Exit 0
		End Main