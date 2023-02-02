output "instance_ip" {
    value = aws_instance.example.private_ip
  }
  
  output "load_balancer_url" {
    value = aws_elb.example.dns_name
  }
  