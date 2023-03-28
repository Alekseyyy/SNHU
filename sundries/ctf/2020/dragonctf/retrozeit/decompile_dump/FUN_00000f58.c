
void FUN_00000f58(void)

{
  int in_D0;
  uint uVar1;
  uint in_D1;
  undefined4 *puVar2;
  undefined4 *in_A0;
  
  while( true ) {
    *in_A0 = 0;
    in_A0[1] = 0;
    in_A0[2] = 0;
    in_D0 = in_D0 + -1;
    if (in_D0 == 0) break;
    in_A0[3] = 0;
    in_A0[4] = 0;
    in_A0[5] = 0;
    puVar2 = in_A0 + 7;
    in_A0[6] = 0;
    in_A0 = in_A0 + 8;
    *puVar2 = 0;
  }
  uVar1 = in_D1 >> 2;
  puVar2 = in_A0 + 3;
  while (uVar1 != 0) {
    *puVar2 = 0;
    uVar1 = uVar1 - 1;
    puVar2 = puVar2 + 1;
  }
  uVar1 = in_D1 & 3;
  while (uVar1 != 0) {
    *(undefined *)puVar2 = 0;
    uVar1 = uVar1 - 1;
    puVar2 = (undefined4 *)((int)puVar2 + 1);
  }
  return;
}

