;redcode
;name Imp Ex
;assert 1
        istep  equ 2667           ; (CORESIZE+1)/3

        spl    #0,         >prime
prime   mov    imp,        imp
        add.a  #istep+1,   launch
launch  jmp    imp-istep-1

imp     mov.i  #0,         istep
end
