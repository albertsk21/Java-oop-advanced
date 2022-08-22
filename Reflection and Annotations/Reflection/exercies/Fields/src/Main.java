import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
//		Method[] methods = richSoilLandClass.getDeclaredMethods();


		Field[] fields = RichSoilLand.class.getDeclaredFields();

		String input = bfr.readLine();
		while (!input.equals("HARVEST")) {

			if (input.equals("private")) {
			printPrivateMethods(fields,input);

			} else if (input.equals("public")) {
				printPublicMethods(fields, input);

			} else if (input.equals("protected")) {
				printProtectedMethods(fields, input);

			} else if (input.equals("all")) {
				printAllMethods(fields);
			}
//			}


			input = bfr.readLine();
		}


	}

	public static void printAllMethods(Field[] fields) {

		for (Field field : fields) {


			int modifiers = field.getModifiers();

			if (Modifier.isPublic(modifiers)) {
				print(field, "public");
			} else if (Modifier.isProtected(modifiers)) {
				print(field, "protected");
			} else if (Modifier.isPrivate(modifiers)) {
				print(field, "private");
			}
		}
	}

	public static void printPublicMethods(Field[] fields, String type) {

		for (Field field : fields) {

			int modifers = field.getModifiers();

			if (Modifier.isPublic(modifers)) {
				print(field, type);
			}
		}
	}

	public static void printPrivateMethods(Field[] fields, String type) {

		for (Field field : fields) {

			int modifers = field.getModifiers();

			if (Modifier.isPrivate(modifers)) {
				print(field, type);
			}
		}
	}

	public static void printProtectedMethods(Field[] fields, String type) {

		for (Field field : fields) {

			int modifers = field.getModifiers();

			if (Modifier.isProtected(modifers)) {
				print(field, type);
			}
		}
	}

	public static void print(Field field, String type) {
		System.out.printf("%s %s %s%n", type, field.getType().getSimpleName(), field.getName());
	}
}


