package co.manager.openaiws.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormDataResponseDTO implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
    @JsonProperty("service_tier")
    private String serviceTier;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getServiceTier() {
        return serviceTier;
    }

    public void setServiceTier(String serviceTier) {
        this.serviceTier = serviceTier;
    }

    public String getSystemFingerprint() {
        return systemFingerprint;
    }

    public void setSystemFingerprint(String systemFingerprint) {
        this.systemFingerprint = systemFingerprint;
    }

    public static class Choice implements Serializable {
        private int index;
        private Message message;
        private Object logprobs;
        @JsonProperty("finish_reason")
        private String finishReason;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public Object getLogprobs() {
            return logprobs;
        }

        public void setLogprobs(Object logprobs) {
            this.logprobs = logprobs;
        }

        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

        public static class Message implements Serializable {
            private String role;
            private String content;
            private Object refusal;
            private List<Object> annotations;

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getRefusal() {
                return refusal;
            }

            public void setRefusal(Object refusal) {
                this.refusal = refusal;
            }

            public List<Object> getAnnotations() {
                return annotations;
            }

            public void setAnnotations(List<Object> annotations) {
                this.annotations = annotations;
            }
        }
    }

    public static class Usage implements Serializable {
        @JsonProperty("prompt_tokens")
        private int promptTokens;
        @JsonProperty("completion_tokens")
        private int completionTokens;
        @JsonProperty("total_tokens")
        private int totalTokens;
        @JsonProperty("prompt_tokens_details")
        private PromptTokensDetails promptTokensDetails;
        @JsonProperty("completion_tokens_details")
        private CompletionTokensDetails completionTokensDetails;

        public int getPromptTokens() {
            return promptTokens;
        }

        public void setPromptTokens(int promptTokens) {
            this.promptTokens = promptTokens;
        }

        public int getCompletionTokens() {
            return completionTokens;
        }

        public void setCompletionTokens(int completionTokens) {
            this.completionTokens = completionTokens;
        }

        public int getTotalTokens() {
            return totalTokens;
        }

        public void setTotalTokens(int totalTokens) {
            this.totalTokens = totalTokens;
        }

        public PromptTokensDetails getPromptTokensDetails() {
            return promptTokensDetails;
        }

        public void setPromptTokensDetails(PromptTokensDetails promptTokensDetails) {
            this.promptTokensDetails = promptTokensDetails;
        }

        public CompletionTokensDetails getCompletionTokensDetails() {
            return completionTokensDetails;
        }

        public void setCompletionTokensDetails(CompletionTokensDetails completionTokensDetails) {
            this.completionTokensDetails = completionTokensDetails;
        }

        public static class PromptTokensDetails implements Serializable {
            @JsonProperty("cached_tokens")
            private int cachedTokens;
            @JsonProperty("audio_tokens")
            private int audioTokens;

            public int getCachedTokens() {
                return cachedTokens;
            }

            public void setCachedTokens(int cachedTokens) {
                this.cachedTokens = cachedTokens;
            }

            public int getAudioTokens() {
                return audioTokens;
            }

            public void setAudioTokens(int audioTokens) {
                this.audioTokens = audioTokens;
            }
        }

        public static class CompletionTokensDetails implements Serializable {
            @JsonProperty("reasoning_tokens")
            private int reasoningTokens;
            @JsonProperty("audio_tokens")
            private int audioTokens;
            @JsonProperty("accepted_prediction_tokens")
            private int acceptedPredictionTokens;
            @JsonProperty("rejected_prediction_tokens")
            private int rejectedPredictionTokens;

            public int getReasoningTokens() {
                return reasoningTokens;
            }

            public void setReasoningTokens(int reasoningTokens) {
                this.reasoningTokens = reasoningTokens;
            }

            public int getAudioTokens() {
                return audioTokens;
            }

            public void setAudioTokens(int audioTokens) {
                this.audioTokens = audioTokens;
            }

            public int getAcceptedPredictionTokens() {
                return acceptedPredictionTokens;
            }

            public void setAcceptedPredictionTokens(int acceptedPredictionTokens) {
                this.acceptedPredictionTokens = acceptedPredictionTokens;
            }

            public int getRejectedPredictionTokens() {
                return rejectedPredictionTokens;
            }

            public void setRejectedPredictionTokens(int rejectedPredictionTokens) {
                this.rejectedPredictionTokens = rejectedPredictionTokens;
            }
        }
    }
}