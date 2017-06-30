.assembly extern mscorlib {}
.assembly exemplo_05{}
.module exemplo_05.exe

.class public _Principal{

.method static public void _principal()
 { 

	  .entrypoint

	  .locals(int64 i,float64 soma,float64 nota2,float64 nota1)
	  ldc.i8 0
	  stloc i
	  ldc.r8 1.0
	  stloc soma
	  r:
	  ldloc i
	  ldc.i8 1
	  add
	  stloc i
	  call void _Principal::_cargaHoraria()
	  ldstr "digite uma nota (enter) após outra: "
	  call void [mscorlib]System.Console::Write(string)
	  ldstr "\n"
	  call void [mscorlib]System.Console::Write(string)
	  call string [mscorlib]System.Console::ReadLine()
	  call float64 [mscorlib]System.Double::Parse(string)
	  stloc nota2
	  call string [mscorlib]System.Console::ReadLine()
	  call float64 [mscorlib]System.Double::Parse(string)
	  stloc nota1
	  ldloc soma
	  ldloc nota1
	  ldloc nota2
	  call float64 _Principal::_media(float64,float64)
	  add
	  stloc soma
	  ldloc i
	  ldc.i8 3
	  ceq
	  brfalse r
	  ldloc soma
	  ldc.i8 3
	  div
	  call void [mscorlib]System.Console::Write(float64)
	  ret
 }
	  .method public static float64 _media(float64 n2,float64 n1) 
{
	  ldarg n1
	  ldarg n2
	  add
	  ldc.i8 2
	  div
	  ret
 }
	  .method public static void _cargaHoraria() { 
 .locals(int64 CH,string disciplina)
	  ldstr "qual a disciplina? "
	  call void [mscorlib]System.Console::Write(string)
	  call string [mscorlib]System.Console::ReadLine()
	  stloc disciplina
	  r:
	  ldstr "qual a CH da disciplina? "
	  call void [mscorlib]System.Console::Write(string)
	  call string [mscorlib]System.Console::ReadLine()
	  call int64 [mscorlib]System.Int64::Parse(string)
	  stloc CH
	  ldloc CH
	  ldc.i8 17
	  cgt
	  brfalse r
	  ldstr "total de créditos: "
	  call void [mscorlib]System.Console::Write(string)
	  ldloc CH
	  ldc.i8 18
	  div
	  call void [mscorlib]System.Console::Write(int64)
	  ldstr "\n"
	  call void [mscorlib]System.Console::Write(string)
	  ret
 }
}