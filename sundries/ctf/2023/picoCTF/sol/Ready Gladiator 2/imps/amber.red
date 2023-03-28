;redcode
;name Imp Ex
;assert 1
        dist   equ 4000           ; CORESIZE/2
        istep  equ 4001           ; CORESIZE/2+1

        mov    imp,        imp+dist

        spl    #0,         }launch1
        spl    launch2,    }launch2
launch1 jmp    imp-2,      }launch2
launch2 jmp    imp+dist-2, }launch1

imp     mov.i  #0,         istep
end
