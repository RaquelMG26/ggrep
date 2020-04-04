	/*1. Programa Grep. Ejemplo:

	java ej1 patro fitxer */
package com.rcanto.ggrep;

import java.io.*;
import java.util.Vector;
public class App
{
	public static void main(String[] args)
	{
		if(args.length < 2)
		{
			System.out.println("Debes especificar el patrón y el nombre del fichero");
			System.exit(0);
		}
		Vector<String> v = compruebaLineas(args[1],args[0]);
		for (String s: v)
			System.out.println(s);
	}

	public static Vector<String> compruebaLineas(String file,String patr)
	{
		Vector<String> v = new Vector<String>();
		String linea;
		File f = null;
		FileReader fr = null;

		f = new File(file);
		try
		{
			fr = new FileReader(f);
		}
		catch(FileNotFoundException FNE)
		{
			System.out.println("Se ha liado parda");
		}
		BufferedReader br = new BufferedReader(fr);
		try
		{
			while((linea = br.readLine()) != null)
				if(linea.contains(patr))	// args[0] és el patró de búsqueda
				    //System.out.println(linea);
				    v.add(linea);
	        	if (br != null) { br.close(); fr.close(); }
			return v;
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			return null;
		}
	}
}
