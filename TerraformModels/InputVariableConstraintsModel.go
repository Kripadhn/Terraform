variable "instance_type" {
	type        = string
	description = "The type of EC2 instance to launch."
  
	default = "t2.micro"
  
	constraint = {
	  condition = can(regex("^t2.*", var.instance_type))
	  error_message = "Instance type must start with 't2.'"
	}
  }
  
  provider "aws" {
	region = "us-west-2"
  }
  
  resource "aws_instance" "example" {
	ami           = "ami-0c55b159cbfafe1f0"
	instance_type = var.instance_type
  }
  