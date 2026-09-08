def puissance (a, b):
	is_int(a)
	is_int(b)
	result = 1
	if b<0:
		for i in range(-b):
			result *= a 
		if a == 0 :
			raise ValueError("0 à une puissance négative est impossible")		
		else : return (1/result)

	for i in range(b):
		result *= a
	return (result)

def is_int (var):
	if type(var) != int:
		raise TypeError("Only integers are allowed")

