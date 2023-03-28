;redcode
;name Imp Ex
;assert 1
        istep  equ 2667           ; (CORESIZE+1)/3

        spl    1                  ; 4 parallel processes
        spl    1

        spl    #0
        add.a  #istep,     launch
launch  jmp    imp-istep*4

imp     mov.i  #0,         istep
end
