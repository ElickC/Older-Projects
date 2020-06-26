main:   loco str1:
		stod cstr:                  ;Allowing a set up of the first string
		call Print:                 ;Displays first string
		call crnl:
		call Scan:		    		;Reads and receives 1st input
		stod binnum1:		    	;Stores 1st input
		call Print:                 ;Displays the string
		call crnl:
		call Scan:                  ;Reads and receives 2nd input
		stod binnum2:               ;Stores 2nd input
		loco Resultloc:
		push                        ;result is pushed to the correct address
		loco str2:
		stod cstr:
		call Print:
		call Addinput:
		halt
	
Print:  lodd on:
        stod 4095
        call xbsywt:
        lodd cstr:
nextw:  pshi
        addd c1:
        stod pstr1:
        pop
        jzer printdone:
        stod 4094
        push
        subd c255:
        jneg printdone:
        call sb:
        insp 1
        push
        call xbsywt:
        pop
        stod 4094
        call xbsywt:
        lodd pstr1:
        jump nextw:
printdone: retn
crnl:   lodd cr:
        stod 4094
        call xbsywt:
        lodd nl:
        stod 4094
        call xbsywt:            
	retn
	
Scan:	lodd on:
		stod 4093
loop:	call rbsywt:	
		lodd 4092
		subd numoff:
		jneg loop:
		push
		
nxtdig:	call rbsywt:
	lodd 4092
	stod nxtchr:
	subd nl:
        jzer endnum:
	mult 10
	lodd nxtchr:
	subd numoff:
	addl 0
	stol 0
	jump nxtdig:
	
endnum: pop
	retn
	
xbsywt: lodd 4095
        subd mask:
        jneg xbsywt:
        retn
		
rbsywt: lodd 4093
        subd mask:
        jneg rbsywt:
        retn
		
sb:     loco 8

loop1:  jzer finish:
        subd c1:
        stod lpcnt:
        lodl 1
        jneg add1:
        addl 1
        stol 1
        lodd lpcnt:
        jump loop1:
		
add1:   addl 1
        addd c1:
        stol 1
        lodd lpcnt:
        jump loop1:
		
finish: lodl 1
        retn 
		
Addinput: lodd binnum1:
	  addd binnum2:
	  jneg Overflow:               ;Proper overflow check
	  stod quotient:	
	  push
	  lodl 2
	  popi                         ;Now in the proper location
	  
Divloop:  lodd mask:
          push
	  lodd quotient:
	  push
	  div
	  lodd counter:
	  addd c1:
          stod counter:               
          lodl 0
	  jzer Divdone:
          loco quotient:
	  popi
	  jump Divloop:
	  
Divdone:  pop
          lodd on:
          stod 4095
          call xbsywt:
		  
doneloop: lodl 0
	  addd numoff:
	  stod 4094
	  call xbsywt:
	  insp 3
	  lodd counter:
	  addd cn1:
	  stod counter:
	  jzer Out:
	  jump doneloop:
Out:	  call crnl:
	  loco 0
          retn
Overflow: loco str3:
	  stod cstr:
	  call Print:
	  call crnl:
	  lodd cn1: 
	  retn
	  
Resultloc: 0
numoff: 48
nxtchr: 0
binnum1: 0
binnum2: 0
lpcnt:  0
mask:   10
on:     8
nl:     10
cr:     13
c1:     1
cn1:    -1
c255:   255
pstr1:  0
cstr:   0
quotient: 0
counter: 0
str1:   "Please enter a 1 to 5 digit number followed by enter."
str2:   "The sum is: "
str3:   "Overflow!"
