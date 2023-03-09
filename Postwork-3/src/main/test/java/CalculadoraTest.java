import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CalculadoraTest {



    @TestFactory
    Stream<DynamicTest> sumaTests() {
        Calculadora calculadora = new Calculadora();
        List <Integer> entradas = IntStream.range(0,1000).boxed().collect(Collectors.toList());
        List <Integer> resultados = IntStream.range(0,1000).map(n->n+3).boxed().collect(Collectors.toList());
        return entradas.stream().map(num -> DynamicTest.dynamicTest("Se suma: 3+"+num,()->{
            assertEquals(calculadora.suma(num,3),resultados.get(num));
        }));
    }

    @TestFactory
    Stream<DynamicTest> restaTests() {
        Calculadora calculadora = new Calculadora();
        List <Integer> entradas = IntStream.range(0,1000).boxed().collect(Collectors.toList());
        List <Integer> resultados = IntStream.range(0,1000).map(n->n-5).boxed().collect(Collectors.toList());
        return entradas.stream().map(num -> DynamicTest.dynamicTest("Se resta:"+num+"-5",()->{
            assertEquals(calculadora.resta(num,5),resultados.get(num));
        }));
    }

    @TestFactory
    Stream<DynamicTest> multTest() {
        Calculadora calculadora = new Calculadora();
        List <Integer> entradas = IntStream.range(0,1000).boxed().collect(Collectors.toList());
        List <Integer> resultados = IntStream.range(0,1000).map(n->n*8).boxed().collect(Collectors.toList());
        return entradas.stream().map(num -> DynamicTest.dynamicTest("Se multiplica:"+num+"*8",()->{
            assertEquals(calculadora.multiplica(num,8),resultados.get(num));
        }));
    }
}
