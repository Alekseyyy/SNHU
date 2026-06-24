
void FUN_00001038(void)

{
  int in_D0;
  uint uVar1;
  uint in_D1;
  undefined4 *in_A0;
  undefined4 *puVar2;
  undefined4 *in_A1;
  undefined4 *puVar3;
  
  while( true ) {
    in_A1[-1] = in_A0[-1];
    in_A1[-2] = in_A0[-2];
    puVar2 = in_A0 + -3;
    puVar3 = in_A1 + -3;
    *puVar3 = *puVar2;
    in_D0 = in_D0 + -1;
    if (in_D0 == 0) break;
    in_A1[-4] = in_A0[-4];
    in_A1[-5] = in_A0[-5];
    in_A1[-6] = in_A0[-6];
    in_A1[-7] = in_A0[-7];
    in_A0 = in_A0 + -8;
    in_A1 = in_A1 + -8;
    *in_A1 = *in_A0;
  }
  uVar1 = in_D1 >> 2;
  while (uVar1 != 0) {
    puVar2 = puVar2 + -1;
    puVar3 = puVar3 + -1;
    *puVar3 = *puVar2;
    uVar1 = uVar1 - 1;
  }
  uVar1 = in_D1 & 3;
  while (uVar1 != 0) {
    puVar2 = (undefined4 *)((int)puVar2 + -1);
    puVar3 = (undefined4 *)((int)puVar3 + -1);
    *(undefined *)puVar3 = *(undefined *)puVar2;
    uVar1 = uVar1 - 1;
  }
  return;
}

