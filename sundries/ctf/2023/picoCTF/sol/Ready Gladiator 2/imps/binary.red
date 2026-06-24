;redcode
;name Imp Ex
;assert 1
        istep  equ 2667           ; (CORESIZE+1)/3

        spl    8
        spl    4
        spl    2
        jmp    imp+istep*0
        jmp    imp+istep*1
        spl    2
        jmp    imp+istep*2
        jmp    imp+istep*3
        spl    4
        spl    2
        jmp    imp+istep*4
        jmp    imp+istep*5
        spl    2
        jmp    imp+istep*6
        jmp    imp+istep*7

imp     mov.i  #0,         istep
end
