;redcode
;name Imp Ex
;assert 1
        istep  equ 2667           ; (CORESIZE+1)/3

launch  spl    istep+1
        mov    launch,     launch+istep+1
imp     mov.i  #0,         istep
end
