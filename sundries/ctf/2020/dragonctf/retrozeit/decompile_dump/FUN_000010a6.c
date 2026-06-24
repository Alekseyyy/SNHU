
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_000010a6(void)

{
  int *piVar1;
  undefined *puVar2;
  int **ppiVar3;
  int iVar4;
  int iVar5;
  undefined *puVar6;
  int aiStack116 [3];
  undefined4 uStack96;
  undefined *puStack92;
  int iStack88;
  undefined4 uStack84;
  undefined *local_50;
  undefined auStack64 [64];
  
  iVar5 = DAT_00000094;
  puStack92 = auStack64;
  local_50 = (undefined *)0x10cc;
  (*(code *)(DAT_00000094 + -0x20a))();
  uStack84 = 0x10d4;
  local_50 = puStack92;
  FUN_00001134();
  uStack84 = 0x14;
  iStack88 = 0x10de;
  FUN_00000068();
  uStack96 = 0x105c;
  puVar2 = &stack0xffffff98;
  ppiVar3 = (int **)&DAT_00000004;
  iStack88 = iVar5;
  iVar5 = _DAT_00000000;
  while (iVar5 != 0) {
    piVar1 = *ppiVar3;
    *(undefined4 *)(puVar2 + -4) = 0x110a;
    iVar4 = (*(code *)(DAT_00000094 + -0x228))();
    *piVar1 = iVar4;
    puVar6 = puVar2;
    if (iVar4 == 0) {
      *(int *)(puVar2 + -4) = piVar1[1];
      puVar6 = puVar2 + -8;
      *(undefined4 *)(puVar2 + -8) = 0x4602122d;
      *(undefined4 *)(puVar2 + -0xc) = 0x1116;
      FUN_000010a6();
    }
    iVar5 = iVar5 + -1;
    puVar2 = puVar6;
    ppiVar3 = ppiVar3 + 1;
  }
  return;
}

