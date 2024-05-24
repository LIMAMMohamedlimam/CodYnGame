def isValid(s: str) -> bool:
    stack = []
    matching_brace = {')': '(', ']': '[', '}': '{'}  # Dictionnaire pour trouver la correspondance

    for char in s:
        if char in matching_brace.values():
            stack.append(char)  # Empiler les ouvertures
        elif char in matching_brace:
            if stack and stack[-1] == matching_brace[char]:
                stack.pop()  # Dépiler si correspondant
            else:
                return False  # Non valide si pas de correspondance ou pile vide
        else:
            return False  # Caractère non valide

    return not stack  # Retourner True si la pile est vide, False sinon
