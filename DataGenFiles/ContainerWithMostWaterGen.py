import random
import json

height = [random.randint(1, 100) for _ in range(random.randint(2, 20))]

data = {"height": height}

with open("container_with_most_water_input.json", "w") as json_file:
    json.dump(data, json_file)
