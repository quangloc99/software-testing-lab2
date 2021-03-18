package se.ifmo.ru.s267880.softwareTesting.lab2;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import se.ifmo.ru.s267880.softwareTesting.lab2.math.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestSystemFunctionNonPositive extends FunctionTest {
    // there are 2 ranges:
    // small range:  [-10, 0) with step 0.25
    // big range: [-100, -10) with step 5
    // above the values are the command for wolfram alpha
	@Parameterized.Parameters(name=PARAM_NAME)
	public static Collection data() {
		return Arrays.asList(new Object[][]{
				// table[{x,  NumberForm[N[(((((csc(x) ^ 2) - sec(x)) ^ 3) * ((csc(x) - (sin(x) ^ 3)) / (sin(x) * cot(x)))) + (((cos(x) + tan(x)) + sin(x)) ^ 2))], {30, 10}]}, {x, -10, -0.1, 0.25}]
				// I also had to change `*^` or `x10^` to `e` by hand.
				{-10., -189.9658815235}, {-9.75, -4174.1889733251}, {-9.5, -7.5340085693e7}, {-9.25, 231079.9142524075}, {-9., 882.3242444150},
				{-8.75, 98.9867053266}, {-8.5, 41.5922841499}, {-8.25, 42.5537009913}, {-8., 175.2725298208}, {-7.75, 242.8153833720},
				{-7.5, 14.5850466222}, {-7.25, 2.9318125430}, {-7., -0.9958637374}, {-6.75, -132.7458604217}, {-6.5, -41432.4053815774},
				{-6.25, 2.2528895048e10}, {-6., 6038.3206356477}, {-5.75, 46.2535387912}, {-5.5, 6.1284974256}, {-5.25, 9.0715728844},
				{-5., 13.1465601858}, {-4.75, -498.2161955116}, {-4.5, -66.8906321575}, {-4.25, -35.7378729345}, {-4., -46.6394516390},
				{-3.75, -148.4100971023}, {-3.5, -2329.6430471113}, {-3.25, -6.0019930510e6}, {-3., 961667.6533263360}, {-2.75, 1393.3028783616},
				{-2.5, 120.3280435953}, {-2.25, 44.2638179879}, {-2., 40.1521121304}, {-1.75, 123.5151467702}, {-1.5, 546.2165468611},
				{-1.25, 18.8013364793}, {-1., 3.5467995803}, {-0.75, 0.0150279564}, {-0.5, -74.5228133316}, {-0.25, -14900.8564665864},

                // table[{x,  NumberForm[N[(((((csc(x) ^ 2) - sec(x)) ^ 3) * ((csc(x) - (sin(x) ^ 3)) / (sin(x) * cot(x)))) + (((cos(x) + tan(x)) + sin(x)) ^ 2))], {30, 10}]}, {x, -100, -10.1, 5}]
				{-100, 47.8581921257}, {-95, 0.0674192798}, {-90, 38.5290588266}, {-85, -212288.0105108557}, {-80, -159.6015357781},
				{-75, 474.2971740586}, {-70, 1.8555146460}, {-65, 38.9851329242}, {-60, -5628.6153875479}, {-55, -1684.7875622713},
				{-50, 9652.5267037032}, {-45, 3.9361960552}, {-40, 50.1378215296}, {-35, -704.4293924821}, {-30, 6.7874718465},
				{-25, 1.3438965936e6}, {-20, 9.1220081101}, {-15, 83.2210416684}

			});
	}

	static final LogarithmMath logMathStub = new LogarithmMathBuilder().build();  // well we dont need it.
    static final TrigonometricMath trigMathStub = new TrigonometricMathBuilder()
			.setSin(new FunctionStub()
					.addValues(new double[][]
						// table[{x,  NumberForm[N[sin(x)], {30, 10}]}, {x, -10, -0.1, 0.25}]
						{{-10., 0.5440211109}, {-9.75, 0.3195191936}, {-9.5, 0.0751511205}, {-9.25, -0.1738894854},
						{-9., -0.4121184852}, {-8.75, -0.6247239538}, {-8.5, -0.7984871126}, {-8.25, -0.9226042102},
						{-8., -0.9893582466}, {-7.75, -0.9945987791}, {-7.5, -0.9379999768}, {-7.25, -0.8230808790},
						{-7., -0.6569865987}, {-6.75, -0.4500440738}, {-6.5, -0.2151199881}, {-6.25, 0.0331792165},
						{-6., 0.2794154982}, {-5.75, 0.5082790775}, {-5.5, 0.7055403256}, {-5.25, 0.8589344934},
						{-5., 0.9589242747}, {-4.75, 0.9992927890}, {-4.5, 0.9775301177}, {-4.25, 0.8949893582},
						{-4., 0.7568024953}, {-3.75, 0.5715613187}, {-3.5, 0.3507832277}, {-3.25, 0.1081951345},
						{-3., -0.1411200081}, {-2.75, -0.3816609921}, {-2.5, -0.5984721441}, {-2.25, -0.7780731969},
						{-2., -0.9092974268}, {-1.75, -0.9839859469}, {-1.5, -0.9974949866}, {-1.25, -0.9489846194},
						{-1., -0.8414709848}, {-0.75, -0.6816387600}, {-0.5, -0.4794255386}, {-0.25, -0.2474039593}})
					.addValues(new double[][]
						// table[{x,  NumberForm[N[sin(x)], {30, 10}]}, {x, -100, -10.1, 5}]
						{{-100, 0.5063656411}, {-95, -0.6832617147}, {-90, -0.8939966636}, {-85, 0.1760756199},
						{-80, 0.9938886539}, {-75, 0.3877816354}, {-70, -0.7738906816}, {-65, -0.8268286795},
						{-60, 0.3048106211}, {-55, 0.9997551734}, {-50, 0.2623748537}, {-45, -0.8509035245},
						{-40, -0.7451131605}, {-35, 0.4281826695}, {-30, 0.9880316241}, {-25, 0.1323517501},
						{-20, -0.9129452507}, {-15, -0.6502878402}} ))
			.setCos(new FunctionStub()
					.addValues(new double[][]
						// table[{x,  NumberForm[N[cos(x)], {30, 10}]}, {x, -10, -0.1, 0.25}]
						{{-10., -0.8390715291}, {-9.75, -0.9475798040}, {-9.5, -0.9971721562}, {-9.25, -0.9847651735},
						{-9., -0.9111302619}, {-8.75, -0.7808456836}, {-8.5, -0.6020119027}, {-8.25, -0.3857479375},
						{-8., -0.1455000338}, {-7.75, 0.1037943572}, {-7.5, 0.3466353178}, {-7.25, 0.5679241733},
						{-7., 0.7539022543}, {-6.75, 0.8930063447}, {-6.5, 0.9765876257}, {-6.25, 0.9994494182},
						{-6., 0.9601702867}, {-5.75, 0.8611924172}, {-5.5, 0.7086697743}, {-5.25, 0.5120854772},
						{-5., 0.2836621855}, {-4.75, 0.0376021529}, {-4.5, -0.2107957994}, {-4.25, -0.4460874899},
						{-4., -0.6536436209}, {-3.75, -0.8205593573}, {-3.5, -0.9364566873}, {-3.25, -0.9941296761},
						{-3., -0.9899924966}, {-2.75, -0.9243023786}, {-2.5, -0.8011436155}, {-2.25, -0.6281736227},
						{-2., -0.4161468365}, {-1.75, -0.1782460556}, {-1.5, 0.0707372017}, {-1.25, 0.3153223624},
						{-1., 0.5403023059}, {-0.75, 0.7316888689}, {-0.5, 0.8775825619}, {-0.25, 0.9689124217}})
					.addValues(new double[][]
						// table[{x,  NumberForm[N[cos(x)], {30, 10}]}, {x, -100, -10.1, 5}]
						{{-100, 0.8623188723}, {-95, 0.7301735610}, {-90, -0.4480736161}, {-85, -0.9843766434},
						{-80, -0.1103872438}, {-75, 0.9217512697}, {-70, 0.6333192031}, {-65, -0.5624538512},
						{-60, -0.9524129804}, {-55, 0.0221267563}, {-50, 0.9649660285}, {-45, 0.5253219888},
						{-40, -0.6669380617}, {-35, -0.9036922051}, {-30, 0.1542514499}, {-25, 0.9912028119},
						{-20, 0.4080820618}, {-15, -0.7596879129}} ))
			.setSec(new FunctionStub()
					.addValues(new double[][]
						// table[{x,  NumberForm[N[sec(x)], {30, 10}]}, {x, -10, -0.1, 0.25}]
						{{-10., -1.1917935067}, {-9.75, -1.0553200858}, {-9.5, -1.0028358632}, {-9.25, -1.0154705172},
						{-9., -1.0975379063}, {-8.75, -1.2806627750}, {-8.5, -1.6610967251}, {-8.25, -2.5923664209},
						{-8., -6.8728506367}, {-7.75, 9.6344351157}, {-7.5, 2.8848762620}, {-7.25, 1.7607984429},
						{-7., 1.3264319005}, {-6.75, 1.1198128725}, {-6.5, 1.0239736544}, {-6.25, 1.0005508851},
						{-6., 1.0414819266}, {-5.75, 1.1611806840}, {-5.5, 1.4110944706}, {-5.25, 1.9527989846},
						{-5., 3.5253200858}, {-4.75, 26.5942219580}, {-4.5, -4.7439275484}, {-4.25, -2.2417127192},
						{-4., -1.5298856565}, {-3.75, -1.2186808804}, {-3.5, -1.0678550472}, {-3.25, -1.0059049881},
						{-3., -1.0101086659}, {-2.75, -1.0818970319}, {-2.5, -1.2482156515}, {-2.25, -1.5919165718},
						{-2., -2.4029979617}, {-1.75, -5.6102223208}, {-1.5, 14.1368329030}, {-1.25, 3.1713576938},
						{-1., 1.8508157177}, {-0.75, 1.3667011247}, {-0.5, 1.1394939273}, {-0.25, 1.0320850240}} )
					.addValues(new double[][]
						// table[{x,  NumberForm[N[sec(x)], {30, 10}]}, {x, -100, -10.1, 5}]
						{{-100, 1.1596638229}, {-95, 1.3695373996}, {-90, -2.2317761279}, {-85, -1.0158713199},
						{-80, -9.0590177381}, {-75, 1.0848913724}, {-70, 1.5789825970}, {-65, -1.7779236426},
						{-60, -1.0499646903}, {-55, 45.1941526431}, {-50, 1.0363059118}, {-45, 1.9035944074},
						{-40, -1.4993896098}, {-35, -1.1065714569}, {-30, 6.4829212350}, {-25, 1.0088752655},
						{-20, 2.4504875210}, {-15, -1.3163300127}} ))
			.setCsc(new FunctionStub()
					.addValues(new double[][]
						// table[{x,  NumberForm[N[csc(x)], {30, 10}]}, {x, -10, -0.1, 0.25}]
						{{-10., 1.8381639609}, {-9.75, 3.1297024403}, {-9.5, 13.3065214977}, {-9.25, -5.7507789951},
						{-9., -2.4264866436}, {-8.75, -1.6007069906}, {-8.5, -1.2523683654}, {-8.25, -1.0838883986},
						{-8., -1.0107562184}, {-7.75, -1.0054305525}, {-7.5, -1.0660981074}, {-7.25, -1.2149474317},
						{-7., -1.5221010626}, {-6.75, -2.2220045952}, {-6.5, -4.6485684984}, {-6.25, 30.1393493896},
						{-6., 3.5788995473}, {-5.75, 1.9674231033}, {-5.5, 1.4173534294}, {-5.25, 1.1642331373},
						{-5., 1.0428352128}, {-4.75, 1.0007077115}, {-4.5, 1.0229863837}, {-4.25, 1.1173317211},
						{-4., 1.3213487088}, {-3.75, 1.7495935558}, {-3.5, 2.8507634375}, {-3.25, 9.2425597911},
						{-3., -7.0861673957}, {-2.75, -2.6201262922}, {-2.5, -1.6709215456}, {-2.25, -1.2852261253},
						{-2., -1.0997501703}, {-1.75, -1.0162746767}, {-1.5, -1.0025113042}, {-1.25, -1.0537578582},
						{-1., -1.1883951058}, {-0.75, -1.4670527245}, {-0.5, -2.0858296429}, {-0.25, -4.0419725012}})
                    .addValues(new double[][]
						// table[{x,  NumberForm[N[csc(x)], {30, 10}]}, {x, -100, -10.1, 5}]
						{{-100, 1.9748575314}, {-95, -1.4635680273}, {-90, -1.1185724072}, {-85, 5.6793779871},
						{-80, 1.0061489243}, {-75, 2.5787709079}, {-70, -1.2921721683}, {-65, -1.2094403893},
						{-60, 3.2807255744}, {-55, 1.0002448866}, {-50, 3.8113408579}, {-45, -1.1752213631},
						{-40, -1.3420780266}, {-35, 2.3354518322}, {-30, 1.0121133531}, {-25, 7.5556235506},
						{-20, -1.0953559364}, {-15, -1.5377805615}} ) )
			.setTan(new FunctionStub()
					.addValues(new double[][]
						// table[{x,  NumberForm[N[tan(x)], {30, 10}]}, {x, -10, -0.1, 0.25}]
						{{-10., -0.6483608275}, {-9.75, -0.3371950228}, {-9.5, -0.0753642388}, {-9.25, 0.1765796457},
						{-9., 0.4523156594}, {-8.75, 0.8000607122}, {-8.5, 1.3263643278}, {-8.25, 2.3917281744},
						{-8., 6.7997114552}, {-7.75, -9.5823974035}, {-7.5, -2.7060138668}, {-7.25, -1.4492795301},
						{-7., -0.8714479827}, {-6.75, -0.5039651470}, {-6.5, -0.2202772003}, {-6.25, 0.0331974945},
						{-6., 0.2910061914}, {-5.75, 0.5902038469}, {-5.5, 0.9955840522}, {-5.25, 1.6773264066},
						{-5., 3.3805150062}, {-4.75, 26.5754142310}, {-4.5, -4.6373320546}, {-4.25, -2.0063090279},
						{-4., -1.1578212823}, {-3.75, -0.6965508511}, {-3.5, -0.3745856402}, {-3.25, -0.1088340255},
						{-3., 0.1425465431}, {-2.75, 0.4129178945}, {-2.5, 0.7470222972}, {-2.25, 1.2386276162},
						{-2., 2.1850398633}, {-1.75, 5.5203799225}, {-1.5, -14.1014199472}, {-1.25, -3.0095696739},
						{-1., -1.5574077247}, {-0.75, -0.9315964599}, {-0.5, -0.5463024898}, {-0.25, -0.2553419212}} )
                    .addValues(new double[][]
						// table[{x,  NumberForm[N[tan(x)], {30, 10}]}, {x, -100, -10.1, 5}]
						{{-100, 0.5872139152}, {-95, -0.9357524721}, {-90, 1.9952004122}, {-85, -0.1788701724},
						{-80, -9.0036549456}, {-75, 0.4207009506}, {-70, -1.2219599181}, {-65, 1.4700382577},
						{-60, -0.3200403894}, {-55, 45.1830879105}, {-50, 0.2719006120}, {-45, -1.6197751905},
						{-40, 1.1172149309}, {-35, -0.4738147204}, {-30, 6.4053311966}, {-25, 0.1335264070},
						{-20, -2.2371609442}, {-15, 0.8559934009}} ))
			.setCot(new FunctionStub()
					.addValues(new double[][]
						// table[{x,  NumberForm[N[cot(x)], {30, 10}]}, {x, -10, -0.1, 0.25}]
						{{-10., -1.5423510454}, {-9.75, -2.9656428249}, {-9.5, -13.2688927333}, {-9.25, 5.6631668747},
						{-9., 2.2108454110}, {-8.75, 1.2499051444}, {-8.5, 0.7539406625}, {-8.25, 0.4181077142},
						{-8., 0.1470650639}, {-7.75, -0.1043580179}, {-7.5, -0.3695472563}, {-7.25, -0.6899980157},
						{-7., -1.1475154224}, {-6.75, -1.9842642015}, {-6.5, -4.5397344729}, {-6.25, 30.1227552131},
						{-6., 3.4363530042}, {-5.75, 1.6943298579}, {-5.5, 1.0044355349}, {-5.25, 0.5961868817},
						{-5., 0.2958129155}, {-4.75, 0.0376287644}, {-4.5, -0.2156412326}, {-4.25, -0.4984277029},
						{-4., -0.8636911545}, {-3.75, -1.4356453637}, {-3.5, -2.6696164850}, {-3.25, -9.1883029713},
						{-3., 7.0152525514}, {-2.75, 2.4217889642}, {-2.5, 1.3386481283}, {-2.25, 0.8073451511},
						{-2., 0.4576575544}, {-1.75, 0.1811469526}, {-1.5, -0.0709148443}, {-1.25, -0.3322734173},
						{-1., -0.6420926159}, {-0.75, -1.0734261485}, {-0.5, -1.8304877217}, {-0.25, -3.9163173646}} )
					.addValues(new double[][]
						// table[{x,  NumberForm[N[cot(x)], {30, 10}]}, {x, -100, -10.1, 5}]
						{{-100, 1.7029569194}, {-95, -1.0686586783}, {-90, 0.5012027834}, {-85, -5.5906470395},
						{-80, -0.1110660066}, {-75, 2.3769853587}, {-70, -0.8183574479}, {-65, 0.6802544048},
						{-60, -3.1246056222}, {-55, 0.0221321748}, {-50, 3.6778144509}, {-45, -0.6173696238},
						{-40, 0.8950829176}, {-35, -2.1105296161}, {-30, 0.1561199522}, {-25, 7.4891553087},
						{-20, -0.4469951089}, {-15, 1.1682333052}} ) )
			.build();

    static final SystemFunction sysFunc = new SystemFunction(trigMathStub, logMathStub);

    public TestSystemFunctionNonPositive(double x, double res) {
		super(x, res, sysFunc);
	}
}
