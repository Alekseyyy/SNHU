;redcode
;name Imp Ex
;assert 1
        dist   equ 4000           ; CORESIZE/2
        istep  equ 4001           ; CORESIZE/2+1

launch  mov    imp,        imp+dist
        spl    imp+dist
imp     mov.i  #0,         istep
end
