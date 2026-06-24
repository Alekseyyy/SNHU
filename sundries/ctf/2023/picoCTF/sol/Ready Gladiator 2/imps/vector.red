;redcode
;name Imp Ex
;assert 1
        istep  equ 2667           ; (CORESIZE+1)/3

        spl    1                  ; 4 parallel processes
        spl    1

        spl    vector,     }0
        jmp    @vector,    }0

vector  jmp    imp+istep*1,imp+istep*0
        jmp    imp+istep*3,imp+istep*2
        jmp    imp+istep*5,imp+istep*4
        jmp    imp+istep*7,imp+istep*6

imp     mov.i  #0,         istep
end
