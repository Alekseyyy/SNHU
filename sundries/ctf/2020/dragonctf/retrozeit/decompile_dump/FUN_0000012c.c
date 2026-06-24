
void FUN_0000012c(int param_1,undefined4 param_2)

{
  undefined4 uVar1;
  int iVar2;
  
  *(undefined2 *)(param_1 + 0x1c) = 9;
  uVar1 = func_0x00000e74(param_2,1000);
  *(undefined4 *)(param_1 + 0x20) = uVar1;
  iVar2 = FUN_00000e68(param_2,1000);
  *(int *)(param_1 + 0x24) = iVar2 * 1000;
  (*(code *)(DAT_00000094 + -0x1ce))();
  return;
}

