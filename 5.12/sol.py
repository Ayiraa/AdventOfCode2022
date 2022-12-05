import copy

with open(r"input5.txt") as f:
    input = []
    for line in f.readlines():
        if line.startswith("move"):
            input.append(line.strip())

STACKS = {
    "1":["B","S","V", "Z", "G", "P", "W"],
    "2":["J","V","B","C","Z","F"],
    "3":["V","L","M","H","N", "Z", "D", "C"],
    "4":["L","D","M","Z", "P", "F", "J", "B"],
    "5":["V","F","C","G","J","B","Q", "H"],
    "6":["G","F","Q","T","S","L", "B"],
    "7":["L","G","C","Z","V"],
    "8":["N","L","G"],
    "9":["J","F","H","C"]
    }

# part 1
stacks = copy.deepcopy(STACKS)
for line in input:
    splitline = line.split()
    for i in range(int(splitline[1])):
        stacks[splitline[5]].append(stacks[splitline[3]].pop())

print(f"Last item in every stack for crane 9000: {''.join([stacks[key][-1] for key in stacks])}")

# part 2
stacks = copy.deepcopy(STACKS)
for line in input:
    splitline = line.split()
    crates = stacks[splitline[3]][-int(splitline[1]):]
    stacks[splitline[3]] = stacks[splitline[3]][:-int(splitline[1])]
    stacks[splitline[5]] += crates

print(f"Last item in every stack for crane 9001: {''.join([stacks[key][-1] for key in stacks])}")