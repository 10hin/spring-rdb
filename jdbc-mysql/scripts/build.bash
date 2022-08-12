#!/usr/bin/env bash

cd "$(dirname "$0")/.." \
  || exit

nerdctl run \
  -v "${HOME}/.docker/config.json":/kaniko/.docker/config.json:ro \
  -v "${PWD}":/workspace \
  gcr.io/kaniko-project/executor:latest \
  --dockerfile=/workspace/package/main/Dockerfile \
  --context=dir:///workspace/ \
  --destination=registry.gitlab.com/10hin/private-infra/spring-rdb/mdbc-mysql:latest \
  --cache=true \
  --cache-repo=registry.gitlab.com/10hin/private-infra/cache \
  --cache-copy-layers \
  --cache-run-layers
