.assembly extern mscorlib {}
.assembly exemplo{}
.module exemplo.exe

.class public _Principal{

.method static public void _principal()
 { .entrypoint
  ldc.i8 1
  call void [mscorlib]System.Console::Write(int64)
  ldstr " "
  call void [mscorlib]System.Console::Write(string)
  ldc.r8 1.5
  call void [mscorlib]System.Console::Write(float64)
  ldstr "\n"
  call void [mscorlib]System.Console::Write(string)
  ldstr "olá mundo!"
  call void [mscorlib]System.Console::Write(string)
  ldc.i8 1
  ldc.i8 1
  add
  call void [mscorlib]System.Console::Write(int64)
  ldc.i8 1
  ldc.i8 1
  sub
  call void [mscorlib]System.Console::Write(int64)
  ldc.i8 1
  ldc.i8 1
  mul
  call void [mscorlib]System.Console::Write(int64)
  ldc.i8 1
  ldc.i8 1
  div
  call void [mscorlib]System.Console::Write(int64)
  ldc.i8 1
  ldc.r8 1.5
  add
  call void [mscorlib]System.Console::Write(float64)
  ldc.i8 1
  ldc.r8 1.5
  sub
  call void [mscorlib]System.Console::Write(float64)
  ldc.i8 1
  ldc.r8 1.5
  mul
  call void [mscorlib]System.Console::Write(float64)
  ldc.r8 1.5
  ldc.r8 1.5
  div
  call void [mscorlib]System.Console::Write(float64)
  ldc.i8 1
  ldc.i8 3
  clt
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 1.0
  ldc.r8 3.5
  clt
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 4
  ldc.i8 3
  clt
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 1
  ldc.i8 3
  cgt
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 1.0
  ldc.r8 3.5
  cgt
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 4.4
  ldc.r8 3.3
  cgt
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 1
  ldc.i8 1
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 3.5
  ldc.r8 3.5
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 1
  ldc.i8 3
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 1
  ldc.i8 1
  cgt
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 3.5
  ldc.r8 3.5
  cgt
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 4.2
  ldc.r8 3.0
  cgt
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 1
  call void [mscorlib]System.Console::Write(int64)
  ldc.i8 1
  ldc.i8 -1
  mul
  call void [mscorlib]System.Console::Write(int64)
  ldc.i4.1
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.0
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.0
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.1
  and
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.0
  and
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.0
  ldc.i4.0
  and
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.0
  ldc.i4.1
  xor
  and
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.1
  or
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.0
  or
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.0
  ldc.i4.0
  or
  call void [mscorlib]System.Console::Write(bool)
  ldc.i4.1
  ldc.i4.0
  ldc.i4.1
  xor
  or
  call void [mscorlib]System.Console::Write(bool)
  ret
 }
}