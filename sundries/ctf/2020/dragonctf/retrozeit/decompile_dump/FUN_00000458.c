
/* WARNING: Could not reconcile some variable overlaps */

void FUN_00000458(undefined4 param_1)

{
  undefined4 local_6c;
  byte abStack104 [100];
  
  FUN_00000ef0(abStack104,100);
  local_6c = 0;
  while (local_6c < 0x27) {
    abStack104[local_6c] = ~*(byte *)(local_6c + 0x3ac) ^ (byte)local_6c;
    local_6c = local_6c + 1;
  }
  FUN_00000e84(param_1,abStack104);
  return;
}

