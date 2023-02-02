data "aws_instance" "example" {
  filter {
    name   = "instance-state-name"
    values = ["running"]
  }
}

output "instance_ids" {
  value = join(", ", data.aws_instance.example.*.id)
}
