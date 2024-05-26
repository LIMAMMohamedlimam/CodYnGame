def is_palindrome(x):


    # Convertir le nombre en une chaîne de caractères
    str_x = str(x)

    # Vérifier si la chaîne est égale à son renversement
    return str_x == str_x[::-1]

def main(generatedData):
    x = generatedData["x"]
    result = is_palindrome(x)
    print(result)

if __name__ == "__main__":
    main()
