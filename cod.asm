ori $s0, $s0, 0x7
or $s1, $zero, $s0
addi $s0, $s0, 0x5
add $s2, $s0, $s1 
sub $s3, $s0, $s1
xori $s4, $s3, 0xA3
xor $s5, $s3, $s2
and $s6, $s4, $s5
andi $s1, $s2, 0xF55F
srl $s4, $s4, 0x1
ori $s7, $zero, 0x1001
sll $s7, $s7, 0x10
sw $s0, 0($s7)
lw $t2, 0($s7)
jump: slt $t0, $s4, $s6
bne $t0, $zero, jump1
addi $s6, $s6, 0x1 
jump1: slti $t1, $s3, 0xAA
beq $t1, $zero, jump2
sll $s3, $s3, 0x4 
j jump
jump2:



