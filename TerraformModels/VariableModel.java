variable "ami" {
  type        = string
  description = "The ID of the Amazon Machine Image (AMI) to use for the instance."
}

provider "aws" {
  region = "us-west-2"
}

resource "aws_instance" "example" {
  ami           = var.ami
  instance_type = "t2.micro"
}
