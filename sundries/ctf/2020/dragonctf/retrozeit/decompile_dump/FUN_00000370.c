
void FUN_00000370(void)

{
  undefined uVar1;
  undefined uVar2;
  undefined4 uVar3;
  byte bVar4;
  byte bVar5;
  int local_a;
  
  local_a = 0;
  while (local_a < 0x32) {
    uVar3 = FUN_00000e94();
    bVar4 = FUN_00000ed4(uVar3,0x27);
    uVar3 = FUN_00000e94();
    bVar5 = FUN_00000ed4(uVar3,0x27);
    if (bVar4 != bVar5) {
      uVar1 = *(undefined *)((uint)bVar4 + 0x3d3);
      uVar2 = *(undefined *)((uint)bVar4 + 0x3ac);
      *(undefined *)((uint)bVar4 + 0x3d3) = *(undefined *)((uint)bVar4 + 0x3d3);
      *(undefined *)((uint)bVar4 + 0x3ac) = *(undefined *)((uint)bVar4 + 0x3ac);
      *(undefined *)((uint)bVar5 + 0x3d3) = uVar1;
      *(undefined *)((uint)bVar5 + 0x3ac) = uVar2;
    }
    local_a = local_a + 1;
  }
  return;
}

