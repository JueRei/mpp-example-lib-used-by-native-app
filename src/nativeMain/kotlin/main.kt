import de.rdvsb.mppexamplelib.Example
import de.rdvsb.mppexamplelib.Greeting
import de.rdvsb.mppexamplelib.Native

fun main(args: Array<String>) {
	val p = Example()

	println("Hello World from ${p.platform}! Native=${Native().isNative}")
	println(Greeting().greeting())
}