
void FUN_0040b450(void)

{
  _FILETIME _Var1;
  DWORD DVar2;
  DWORD DVar3;
  DWORD DVar4;
  _FILETIME local_38;
  LARGE_INTEGER local_30;
  
  local_38.dwLowDateTime = 0;
  local_38.dwHighDateTime = 0;
  if (DAT_004a7200 != 0x2b992ddfa232) {
    DAT_004a7210 = ~DAT_004a7200;
    return;
  }
  GetSystemTimeAsFileTime(&local_38);
  _Var1 = local_38;
  DVar2 = GetCurrentProcessId();
  DVar3 = GetCurrentThreadId();
  DVar4 = GetTickCount();
  QueryPerformanceCounter(&local_30);
  DAT_004a7200 = ((ulonglong)DVar4 ^
                 (ulonglong)DVar3 ^ (ulonglong)DVar2 ^ (ulonglong)_Var1 ^ local_30.QuadPart) &
                 0xffffffffffff;
  if (DAT_004a7200 == 0x2b992ddfa232) {
    DAT_004a7210 = 0xffffd466d2205dcc;
    DAT_004a7200 = 0x2b992ddfa233;
  }
  else {
    DAT_004a7210 = ~DAT_004a7200;
  }
  return;
}

