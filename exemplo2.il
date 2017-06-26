.assembly extern mscorlib {}
.assembly exemplo2{}
.module exemplo2.exe

.class public _Principal{

.method static public void _principal()
 { .entrypoint
  ldc.i8 1
  ldc.i8 3
  clt
  ldc.i8 1
  ldc.i8 3
  ceq
  or
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 1.0
  ldc.r8 3.0
  clt
  ldc.r8 1.0
  ldc.r8 3.0
  ceq
  or
  call void [mscorlib]System.Console::Write(bool)
  ret
 }
}