
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

ulonglong FUN_00401180(undefined8 param_1,undefined8 param_2,undefined8 param_3)

{
  int iVar1;
  void **ppvVar2;
  char cVar3;
  ulonglong uVar4;
  ulonglong uVar5;
  undefined8 *puVar6;
  int iVar7;
  char **ppcVar8;
  char *pcVar9;
  undefined8 *puVar10;
  size_t sVar11;
  void *_Dst;
  undefined8 *puVar12;
  ulonglong uVar13;
  longlong lVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  LPSTARTUPINFOA p_Var17;
  undefined8 uVar18;
  longlong unaff_GS_OFFSET;
  bool bVar19;
  undefined local_a8 [64];
  ushort local_68;
  
  p_Var17 = (LPSTARTUPINFOA)local_a8;
  for (lVar14 = 0xd; lVar14 != 0; lVar14 = lVar14 + -1) {
    *(undefined8 *)p_Var17 = 0;
    p_Var17 = (LPSTARTUPINFOA)&p_Var17->lpReserved;
  }
  uVar13 = (ulonglong)DAT_004d1610;
  if (DAT_004d1610 != 0) {
    GetStartupInfoA((LPSTARTUPINFOA)local_a8);
  }
  uVar4 = *(ulonglong *)(*(longlong *)(unaff_GS_OFFSET + 0x30) + 8);
  while( true ) {
    LOCK();
    bVar19 = DAT_004d2420 == 0;
    DAT_004d2420 = DAT_004d2420 ^ (ulonglong)bVar19 * (DAT_004d2420 ^ uVar4);
    uVar5 = !bVar19 * DAT_004d2420;
    UNLOCK();
    if (uVar5 == 0) break;
    if (uVar4 == uVar5) {
      bVar19 = true;
      goto joined_r0x004011ff;
    }
    Sleep(1000);
  }
  bVar19 = false;
joined_r0x004011ff:
  if (DAT_004d2428 == 1) {
    _amsg_exit(0x1f);
  }
  else if (DAT_004d2428 == 0) {
    DAT_004d2428 = 1;
    _initterm();
  }
  else {
    DAT_004d1004 = 1;
  }
  if (DAT_004d2428 == 1) {
    _initterm();
    DAT_004d2428 = 2;
  }
  if (!bVar19) {
    LOCK();
    DAT_004d2420 = 0;
    UNLOCK();
  }
  uVar18 = 0;
  uVar16 = 2;
  uVar15 = 0;
  tls_callback_0(0,2);
  FUN_0040ba50(uVar15,uVar16,uVar18,uVar13);
  DAT_004d1640 = SetUnhandledExceptionFilter((LPTOP_LEVEL_EXCEPTION_FILTER)&LAB_0040bfa0);
  FUN_0040beb0();
  FUN_004175f0(&LAB_00401000);
  FUN_0040b850();
  _DAT_004d2410 = &IMAGE_DOS_HEADER_00400000;
  ppcVar8 = (char **)FUN_004176d0();
  iVar7 = DAT_004d1020;
  bVar19 = false;
  pcVar9 = *ppcVar8;
  if (pcVar9 != (char *)0x0) {
    do {
      cVar3 = *pcVar9;
      if (cVar3 < '!') {
        if ((cVar3 == '\0') || (!bVar19)) goto LAB_004012d0;
        bVar19 = true;
      }
      else if (cVar3 == '\"') {
        bVar19 = (bool)(bVar19 ^ 1);
      }
      pcVar9 = pcVar9 + 1;
    } while( true );
  }
  goto LAB_004012f7;
LAB_004012d0:
  _DAT_004d2418 = pcVar9;
  if (cVar3 != '\0') {
    do {
      pcVar9 = pcVar9 + 1;
      _DAT_004d2418 = pcVar9;
      if (*pcVar9 == '\0') break;
    } while (*pcVar9 < '!');
  }
LAB_004012f7:
  if ((DAT_004d1610 != 0) && (_DAT_004a4000 = 10, (local_a8[60] & 1) != 0)) {
    _DAT_004a4000 = (uint)local_68;
  }
  iVar1 = DAT_004d1020 + 1;
  puVar10 = (undefined8 *)malloc((longlong)iVar1 * 8);
  puVar6 = DAT_004d1018;
  puVar12 = puVar10;
  if (0 < iVar7) {
    lVar14 = 0;
    do {
      sVar11 = strlen(*(char **)((longlong)puVar6 + lVar14));
      _Dst = malloc(sVar11 + 1);
      *(void **)((longlong)puVar10 + lVar14) = _Dst;
      ppvVar2 = (void **)((longlong)puVar6 + lVar14);
      lVar14 = lVar14 + 8;
      memcpy(_Dst,*ppvVar2,sVar11 + 1);
    } while ((ulonglong)(iVar7 - 1) * 8 + 8 != lVar14);
    puVar12 = puVar10 + (longlong)iVar1 + -1;
  }
  *puVar12 = 0;
  DAT_004d1018 = puVar10;
  FUN_0040b410();
  *(undefined8 *)__initenv_exref = DAT_004d1010;
  uVar13 = FUN_00401789();
  DAT_004d100c = (uint)uVar13;
  if (DAT_004d1008 != 0) {
    if (DAT_004d1004 == 0) {
      _cexit();
      uVar13 = (ulonglong)DAT_004d100c;
    }
    return uVar13;
  }
                    /* WARNING: Subroutine does not return */
  exit(DAT_004d100c);
}

