
int FUN_00001134(void)

{
  int iVar1;
  int unaff_D2;
  int *in_A0;
  int **unaff_A2;
  
  while( true ) {
    iVar1 = *in_A0;
    if (*in_A0 != 0) {
      iVar1 = (*(code *)(DAT_00000094 + -0x19e))();
    }
    unaff_D2 = unaff_D2 + -1;
    if (unaff_D2 == 0) break;
    in_A0 = *unaff_A2;
    unaff_A2 = unaff_A2 + 1;
  }
  return iVar1;
}

