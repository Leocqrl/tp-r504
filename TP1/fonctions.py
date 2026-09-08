def puissance (a, b):
	is_int(a)
	is_int(b)
	return (a**b)

def is_int (var):
	if not type(var) is int:
		raise TypeError("Only integers are allowed")
