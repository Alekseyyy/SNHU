;redcode
;name Imp Ex
;assert 1
        istep  equ 2667           ; (CORESIZE+1)/3

        spl    1                  ; 8 parallel processes
        spl    1
        spl    1
        spl    2
launch  jmp    imp
        add.a  #istep,     launch

;       dat    ?,          ?

imp     mov.i  #0,         istep
end
