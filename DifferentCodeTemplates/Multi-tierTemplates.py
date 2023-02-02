provider "aws" {
  region = "us-west-2"
}

module "frontend" {
  source = "./module/frontend"

  vpc_id = aws_vpc.example.id
}

module "backend" {
  source = "./module/backend"

  vpc_id = aws_vpc.example.id
}

resource "aws_vpc" "example" {
  cidr_block = "10.0.0.0/16
